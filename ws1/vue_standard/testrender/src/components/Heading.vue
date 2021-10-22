

<script lang="ts">
import { Component, Vue, Prop } from "vue-property-decorator";
import Test from "./Test.vue";
@Component
export default class extends Vue {
  @Prop()
  tag!: string;
  @Prop() msg!: string;
  list: string[] = ["苹果", "香蕉", "葡萄"];
  render(createElement: Function) {
    // return createElement(
    //   this.tag,
    //   {},
    //   this.list.map(element => createElement("li", {}, element))
    // );
    return createElement(Test, { props: { msg: "Test组件" } });
  }
}
</script>

<style scoped>
</style>