<template>
    <div>
        <div class="btn" :class="primary?'primary':''">我是按钮</div>
    </div>
</template>

<script>
    export default {
        props:{
            primary:Boolean
        }
    }
</script>

<style scoped>
.btn{width: 120px; height: 50px;background: #5696ff; color:#fff ;text-align: center;line-height: 50px;border-radius: 50px;}
.primary{background: green;}
</style>