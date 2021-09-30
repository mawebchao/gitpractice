declare module '*.vue' {
  import Vue from 'vue'
  export default Vue
}
import Vue from 'vue' // 需要在 declare 外引入
import User from 'src/model/User'
declare module 'vue/types/vue' {
	interface Vue {
		$axios: any,
		$User:User
	}
}