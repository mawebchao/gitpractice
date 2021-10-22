<template>
    <div>
        {{msg}}
    </div>
</template>

<script lang="ts">
    import { Component, Vue, Prop } from 'vue-property-decorator';

    @Component
    export default class  extends Vue {
        @Prop() msg!:string;
    }
</script>

<style scoped>

</style>