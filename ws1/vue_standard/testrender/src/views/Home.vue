<template>
  <div class="home">
    <Heading tag="ul" msg="hhh"/>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
import Heading from '../components/Heading.vue'
@Component({
  components: {
    HelloWorld,Heading
  },
})
export default class Home extends Vue {}
</script>
