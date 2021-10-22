import Vue from 'vue' // 需要在 declare 外引入

declare module '*.vue' {
  import Vue from 'vue'
  export default Vue
}
// declare module "*.less" {
//     const less: any;
//     export default less;
// }
declare module 'vue/types/vue' {
	interface Vue {
		$axios: any,
		global_func(id:number,name:string):Function
	}
}