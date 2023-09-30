import axios from 'axios'

const request = axios.create({
    baseURL: 'http://localhost:9090',  // 注意！ ！ 這裡是全域統一加上了'/api' 前綴，也就是說所有介面都會加上'/api'前綴在，頁面裡面寫介面的時候就不要加'/api'了，否則會出現2個'/ api'，類似'/api/api/user'這樣的報錯，切記！ ！ ！
    timeout: 5000
})

// request 攔截器
// 可以自請求發送前對請求做一些處理
// 例如統一加token，對請求參數統一加密
request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';

    // config.headers['token'] = user.token;  // 設定請求頭
    return config
}, error => {
    return Promise.reject(error)
});

// response 攔截器
// 可以在介面回應後統一處理結果
request.interceptors.response.use(
    response => {
        let res = response.data;
        // 如果是回傳的文件
        if (response.config.responseType === 'blob') {
            return res
        }
        // 相容服務端傳回的字串數據
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        return res;
    },
    error => {
        console.log('err' + error) // for debug
        return Promise.reject(error)
    }
)


export default request

