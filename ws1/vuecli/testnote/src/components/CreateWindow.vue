<template>
  <div class="windowWrap">
    <div class="formWrap">
      <div class="innerformwrap">
        <el-form :inline="true" :model="jlItem" class="demo-form-inline" ref="jlItem">
          <el-form-item>
            <el-input v-model="jlItem.title" placeholder="标题" style="width:10rem"></el-input>
          </el-form-item>
          <el-button style="width:0.13rem;height:0.02rem;" id="catebutton">
            <template>
              <el-dropdown style="text-align:center" placement="bottom" @command="updateCateId">
                <span class="el-dropdown-link">
                  {{$store.state.cateList[jlItem.cateId]}}
                  <i
                    class="el-icon-arrow-down el-icon--right"
                  ></i>
                </span>

                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item :command="0">工作</el-dropdown-item>
                  <el-dropdown-item :command="1">生活</el-dropdown-item>
                  <el-dropdown-item :command="2">学习</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </template>
          </el-button>
          <i
            class="el-icon-error"
            style="font-size: 1.6rem;margin-right:0.48rem;margin-top:0.5rem;display:inline-block;float:right"
            @click="closeCreateWindow()"
          ></i>
          <i
            class="el-icon-s-management"
            style="font-size: 1.6rem;margin-right:0.28rem;margin-top:0.5rem;display:inline-block;float:right"
            @click="save('jlItem')"
          ></i>
          <el-form-item style="margin-top:-0.8rem">
            <el-input
              type="textarea"
              v-model="jlItem.content"
              :rows="15"
              style="width:150%;"
              placeholder="内容"
            ></el-input>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class extends Vue {
  
  jlItem:any = {
    // title: this.$store.state.nowEditMemoItem.title,
    // content: this.$store.state.nowEditMemoItem.content,
    // cateId: this.$store.state.nowEditMemoItem.cateId,
    // id: this.$store.state.nowEditMemoItem.id
    title: "",
    content: "",
    cateId: 0,
    id: -1
  };
  created(){
    this.jlItem=this.$store.state.nowEditMemoItem
  }
  closeCreateWindow(){
      this.$store.commit('showWindow',false)
  }
  save = (formName: string) => {
    console.log("this.jlItem", this.jlItem);
    if (this.jlItem.title == "") {
      this.$message({
        showClose: true,
        message: "标题不能为空",
        type: "error"
      });
    }else{
        if(this.jlItem.id==-1){
            //新建记录
            delete this.jlItem.id
            this.$store.state.dataHelper.addRecord(this.jlItem)
        }else{
            //更新记录
            let id=this.jlItem.id
            
            delete this.jlItem.id

            this.$store.state.dataHelper.updateCateId(id+"",this.jlItem)
        }
        this.$store.commit('showWindow',false)
        this.$router.go(0);
    }
  };
  updateCateId(command: any) {
    this.jlItem.cateId = command;
  }
}
</script>
<style>
/* .input-with-textarea .el-form-item__content{
   ;
} */
#catebutton {
  position: relative;
  margin-top: 0.5rem;
}
#catebutton > span {
  position: absolute;
  left: 10%;
  top: 21%;
}
</style>
<style scoped>
* {
  font-size: 4px;
}

.windowWrap {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.4);
  position: fixed;
  left: 0;
  top: 0;
}
.formWrap {
  position: fixed;
  left: 10%;
  width: 80%;
  top: 25%;
  height: 50%;
  background: white;
}
.innerformwrap {
  margin-top: 5%;
  margin-left: 5%;
}
</style>
