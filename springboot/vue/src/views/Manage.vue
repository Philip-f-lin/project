<template>
  <el-container style="min-height: 100vh">

    <el-aside :width="sideWidth + 'px'" style="background-color: rgb(238, 241, 246); box-shadow: 2px 0 6px rgb(0 21 41 / 35%)">
      <Aside :isCollapse="isCollapse" :logoTextShow="logoTextShow" />
    </el-aside>

    <el-container>
      <el-header style="border-bottom: 1px solid #ccc;">
        <Header :collapseBtnClass="collapseBtnClass" :collapse="isCollapse"/>
      </el-header>

      <el-main>
<!--        表示當前頁面的子路由會在 router-view 裡面展示-->
        <router-view />
      </el-main>
    </el-container>
  </el-container>

</template>

<script>

import Aside from "@/components/Aside.vue";
import Header from "@/components/Header.vue";

export default {
  name: 'Home',
  data() {
    return {

      msg: "Hello Vue",
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      sideWidth: 200,
      logoTextShow: true,
      headerBg: 'headerBg'
    }
  },
  components:{
    Aside,
    Header
  },
  methods: {
    collapse() { // 點擊收縮按鈕觸發
      this.isCollapse = !this.isCollapse
      if (this.isCollapse) {  // 收縮
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      } else {  // 展開
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    }
  }
}
</script>


