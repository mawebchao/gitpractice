<template>
    <div>
        我是About组件的内容页面
        <button @click="jump">跳转</button>
    </div>
</template>

<script>
    export default {
        methods:{
            jump(){
                this.$router.push("/about/title/123");
            }
        }
    }
</script>

<style scoped>

</style>