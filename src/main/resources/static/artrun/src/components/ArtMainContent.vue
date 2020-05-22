<template>
	<section class="popular-deals section bg-gray">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-title">
						<h2>Paintings</h2>
						<p></p>
					</div>
				</div>
			</div>
			<div class="row">
						<div class="col-sm-12 col-lg-4" v-bind:key = "painting.id" v-for="painting in paintings">
							<!-- product card -->
							<div class="product-item bg-light">
								<div class="card">
									<div class="thumb-content">
										<!-- <div class="price">$200</div> -->
										<router-link :to="'/art/'+painting.id">
											<img
												class="card-img-top"
												:src="require('../assets/media/'+painting.id+'.jpg')"
												alt="Card image cap"
											/>
										</router-link>
									</div>
									<div class="card-body">
										<h4 class="card-title">
											<a href="single.html">{{painting.title+' by '+painting.artist}}</a>
											<p>{{painting.price}}INR</p>
										</h4>
									</div>
								</div>
							</div>
						</div>
				</div>
			</div>
	</section>
</template>

<script>
const axios = require('axios');
export default {
	name: "ArtMainContent",
	props: {
		msg: String
	},
	data() {
		return {
			paintings : null
		}
	},
	mounted() {
		axios
		.get('http://localhost:33445/getallart')
		.then(response => (this.paintings = response.data))
	},
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
