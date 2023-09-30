<template>
<div>

  <div style="margin: 10px 0">
    <el-input style="width: 200px" placeholder="請輸入名稱" suffix-icon="el-icon-search"
              v-model="username"></el-input>
    <el-input style="width: 200px" placeholder="請輸入信箱" suffix-icon="el-icon-message" class="ml-5"
              v-model="email"></el-input>
    <el-input style="width: 200px" placeholder="請輸入地址" suffix-icon="el-icon-position" class="ml-5"
              v-model="address"></el-input>
    <el-button class="ml-5" type="primary" @click="load">搜尋</el-button>
    <el-button type="warning" @click="reset">重置</el-button>
  </div>

  <div style="margin: 10px 0">
    <el-button type="primary" @click="handleAdd">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
    <el-popconfirm
        class="ml-5"
        confirm-button-text='確定'
        cancel-button-text='取消'
        icon="el-icon-info"
        icon-color="red"
        title="確定要刪除這些資訊嗎？"
        @confirm="delBatch"
    >
      <el-button type="danger" slot="reference">刪除多筆 <i class="el-icon-remove-outline"></i></el-button>
    </el-popconfirm>
    <!--          <el-button type="primary" class="ml-5">下載 <i class="el-icon-bottom"></i></el-button>
              <el-button type="primary">上傳 <i class="el-icon-top"></i></el-button>-->
  </div>

  <el-table :data="tableData" border stripe :header-cell-class-name="'headerBg'" @selection-change="handleSelectionChange">>
    <el-table-column type="selection" width="55"></el-table-column>
    <el-table-column prop="id" label="ID" width="80"></el-table-column>
    <el-table-column prop="username" label="帳號" width="140"></el-table-column>
    <el-table-column prop="nickname" label="姓名" width="120"></el-table-column>
    <el-table-column prop="email" label="信箱"></el-table-column>
    <el-table-column prop="phone" label="電話"></el-table-column>
    <el-table-column prop="address" label="地址"></el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button type="success" @click="handleEdit(scope.row)">編輯 <i class="el-icon-edit"></i></el-button>
        <el-popconfirm
            class="ml-5"
            confirm-button-text='確定'
            cancel-button-text='取消'
            icon="el-icon-info"
            icon-color="red"
            title="確定要刪除嗎？"
            @confirm="del(scope.row.id)"
        >
          <el-button type="danger" slot="reference">刪除 <i class="el-icon-remove-outline"></i></el-button>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>
  <div style="padding: 10px 0">
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-size="pageSize"
        :pager-count="11"
        layout="prev, pager, next"
        :total="total">
    </el-pagination>
    <!--          <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="pageNum"
                  :page-sizes="[2, 5, 10, 20]"
                  :page-size="pageSize"
                  layout="total, sizes, prev, pager, next, jumper"
                  :total="total">
              </el-pagination>-->
  </div>

  <el-dialog title="使用者資訊" :visible.sync="dialogFormVisible" width="30%">
    <el-form label-width="80px" size="small">
      <el-form-item label="帳號">
        <el-input v-model="form.username" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.nickname" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="信箱">
        <el-input v-model="form.email" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="電話">
        <el-input v-model="form.phone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="form.address" autocomplete="off"></el-input>
      </el-form-item>

    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="save">確 定</el-button>
    </div>
  </el-dialog>

</div>
</template>

<script>
export default {
  name: "User",
  data(){
    return{
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 3,
      username: "",
      email: "",
      address: "",
      form:{},
      dialogFormVisible: false,
      multipleSelection: []
    }
  },
  created(){
    // 請求分頁查詢數據
    this.load()
  },
  methods:{
    load() {
      this.request.get("/user/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
          email: this.email,
          address: this.address
        }
      }).then(res => {
        console.log(res)

        this.tableData = res.records;
        this.total = res.total;
      })

      /*fetch("http://localhost:9090/user/page?pageNum=" + this.pageNum + "&pageSize=" + this.pageSize+ "&username=" + this.username)
          .then(res => res.json())
          .then(res => {
        console.log(res)
        this.tableData = res.records;
        this.total = res.total;
      })*/
    },
    save(){
      this.request.post("/user/save", this.form).then(res =>{
        if(res){
          this.$message.success("儲存成功")
          this.dialogFormVisible = false;
          this.load()
        }else{
          this.$message.error("儲存失敗")
        }
      })
    },
    // 新增
    handleAdd(){
      this.dialogFormVisible = true
      this.form = {}
    },
    // 修改
    handleEdit(row){
      this.form = row
      this.dialogFormVisible = true;
    },
    // 刪除
    del(id){
      this.request.delete("/user/" + id).then(res =>{
        if(res){
          this.$message.success("刪除成功")
          this.load()
        }else{
          this.$message.error("刪除失敗")
        }
      })
    },
    handleSelectionChange(val){
      console.log(val)
      this.multipleSelection = val
    },
    delBatch(){
      let ids = this.multipleSelection.map(v => v.id) // 把object的陣列，變成裝著id的陣列 [{}, {}, {}] => [1, 2, 3]
      this.request.post("/user/del/batch", ids).then(res =>{
        if(res){
          this.$message.success("多筆資訊刪除成功")
          this.load()
        }else{
          this.$message.error("多筆資訊刪除失敗")
        }
      })
    },
    reset() {
      this.username = ""
      this.email = ""
      this.address = ""
      this.load()
    },
    handleSizeChange(pageSize) {
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    }, handleCurrentChange(pageNum) {
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    }
  }
}
</script>


<style>
.headerBg {
  background: #eee !important;
}

</style>