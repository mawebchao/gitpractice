<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <p>{{num}}</p>
    <button @click="increment">+1</button>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  data(){
    return {
      num:1
    }
  },
  methods:{
    increment(){
      this.num++
    }
  }
}
</script>
