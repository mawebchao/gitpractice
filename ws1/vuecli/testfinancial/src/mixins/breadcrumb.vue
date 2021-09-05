

<script>
export default {
    data(){
        return{
            routeitems:[]
        }
    },
    watch:{
        $route:()=>{
            this.routeitems=this.$route.meta
        }
    },
    mounted(){
        this.routeitems=this.$route.meta
    }
};
</script>

<style scoped>
</style>