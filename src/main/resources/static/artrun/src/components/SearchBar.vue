<template lang="html">
<div class="container">
	<div class="row">
		<div class="col-lg-12">
		<input
        class="inputField__field"
        v-on="$listeners"
        v-bind="$attrs"
        />
		</div>
	</div>

</div>
</template>

<script lang="js">

  export default  {
    name: 'search-bar',
    props: [],
    mounted () {
    },
    data () {
	return {
    };
    },
    methods: {
		
    },
    computed: {

    }
}


</script>

<style scoped lang="scss">
.inputField__container {
  display: inline-block;
  text-align: left;
  margin: 10px 0;
  .inputField__label {
    font-size: 14px;
    opacity: 0.8;
  }
  .inputField__wrapper {
    padding: 10px;
    border-radius: 5px;
    border: 1px solid rgba($color: #000000, $alpha: 0.1);
    &.focus {
      border: 1px solid #42b983a0;
    }
    .inputField__field {
      font-size: 16px;
      color: #333333;
      border: none;
      width: 100%;
      &:focus {
        outline: none;
      }
    }
  }
}
</style>
