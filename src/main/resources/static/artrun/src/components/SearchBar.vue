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
										<form v-on:submit="doSearch">
											<div class="form-row">
												<div class="form-group col-md-4">
													<input type="text" class="form-control my-2 my-lg-1" id="inputtext4" placeholder="What are you looking for" v-model="text">
												</div>
												<div class="form-group col-md-3">
													<select class="w-100 form-control mt-lg-1 mt-md-2" style="display: none;">
														<option>Category</option>
														<option value="paiting">Painting</option>
														<option value="handicraft">Handi craft</option>
													</select>
													<div class="nice-select w-100 form-control mt-lg-1 mt-md-2" tabindex="0">
														<span class="current">Category</span>
														<ul class="list">
															<li data-value="Category" class="option selected">Category</li>
															<li data-value="painting" class="option">painting</li>
															<li data-value="handicraft" class="option">hanicraft</li>
														</ul>
													</div>
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
import { mapGetters } from 'vuex';
import {
  mapActions as mapSearchActions,
  mapGetters as mapSearchGetters,
  getterTypes,
  actionTypes,
} from 'vuex-search';
  export default  {
    name: 'src-components-search-bar',
    props: [],
    mounted () {

    },
    data () {
      return {
			text:''
      }
    },
    methods: {
		...mapSearchActions("artifacts", {
		searchContacts: actionTypes.search,
		}),
		doSearch(event) {
			event.preventDefault();
			this.searchContacts(this.text);
			console.log(this.resultIds);
			this.searchContacts(this.text);
			console.log(this.resultIds);
		},

    },
    computed: {
		...mapGetters({
      itemsMap: 'currentContacts',
      generating: 'isGenerating',
    }),
    items() {
      return Object.values(this.itemsMap);
    },
		...mapSearchGetters('artifacts', {resultIds: getterTypes.result}),
		results() {
      return this.resultIds.map(id => this.itemsMap[id]);
    },
    }
}


</script>

<style scoped>
.src-components-search-bar {
}
</style>
