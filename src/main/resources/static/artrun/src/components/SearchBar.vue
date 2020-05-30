<template lang="html">

<section class="hero-area bg-1 text-center overly">
	<!-- Container Start -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Advance Search -->
				<div class="advance-search">
						<div class="container">
							<div class="row justify-content-center">
								<div class="col-lg-12 col-md-12 align-content-center">
										<form>
											<div class="form-row">
												<div class="form-group col-md-4">
													<input type="text" class="form-control my-2 my-lg-1" id="inputtext4" placeholder="What are you looking for">
												</div>
												<div class="form-group col-md-3">
													<select class="w-100 form-control mt-lg-1 mt-md-2" style="display: none;">
														<option>Category</option>
														<option value="1">Painting</option>
														<option value="2">Handi craft</option>
													</select><div class="nice-select w-100 form-control mt-lg-1 mt-md-2" tabindex="0"><span class="current">Category</span><ul class="list"><li data-value="Category" class="option selected">Category</li><li data-value="1" class="option">Top rated</li><li data-value="2" class="option">Lowest Price</li><li data-value="4" class="option">Highest Price</li></ul></div>
												</div>
												<div class="form-group col-md-2 align-self-center">
													<button type="submit" class="btn btn-primary">Search Now</button>
												</div>
											</div>
										</form>
									</div>
								</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</section>

</template>

<script lang="js">

  export default  {
    name: 'src-components-search-bar',
    props: [],
    mounted () {

    },
    data () {
      return {

      }
    },
    methods: {

    },
    computed: {

    }
}


</script>

<style scoped>
.src-components-search-bar {
}
</style>
