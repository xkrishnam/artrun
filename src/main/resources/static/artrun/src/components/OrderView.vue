<template lang="html">

  <section class="dashboard section">
	<!-- Container Start -->
	<div class="container">
		<!-- Row Start -->
		<div class="row">
			<div class="col-md-12 offset-md-0 col-lg-12 offset-lg-0">
				<!-- Recently Favorited -->
				<div class="widget dashboard-container my-adslist">
					<h3 class="widget-header">My Ads</h3>
					<table class="table table-responsive product-dashboard-table">
						<thead>
							<tr>
								<th class="text-center">order id</th>
								<th class="text-center">Date</th>
                <th class="text-center">Address of delivery</th>
								<th class="text-center">Amount</th>
                <th class="text-center">Order status</th>
								<th class="text-center">Action</th>
							</tr>
						</thead>
						<tbody>
							<tr v-bind:key = "order.id" v-for="order in orderedOrders">

								<td>
									{{order.id}}
                </td>
								<td class="product-details">
									{{order.createdDate}}
								</td>
								<td class="product-category">
                  {{order.address}}
                </td>
                <td class="product-category">
                  {{order.cart?order.cart.cartTotal:0}}
                </td>
                <td class="product-category">
                  {{order.status}}
                </td>
								<td class="action" data-title="Action">
									<div class="">
										<ul class="list-inline justify-content-center">
											<li class="list-inline-item">
                        <router-link :to="'/vieworder/'+order.id" 
                        data-toggle="tooltip" data-placement="top" title="View Details" class="edit">
													<i class="fa fa-eye"></i>
												</router-link>
											</li>
											<li class="list-inline-item">
												<a data-toggle="tooltip" data-placement="top" title="Cancel order" class="delete" v-on:click="cancelOrder(order.id, $event)">
													<i class="fa fa-trash"></i>
												</a>
											</li>
										</ul>
									</div>
								</td>
							</tr>
						</tbody>
					</table>

				</div>
				
			</div>
		</div>
		<!-- Row End -->
	</div>
	<!-- Container End -->
</section>

</template>

<script lang="js">
  const axios = require('axios');
  var _ = require('lodash');
  export default  {
    name: 'order-view',
    props: [],
    mounted () {
      if(this.$session.has('user')){
        this.orders=this.$session.get('user').orders;
      }
    },
    data () {
      return {
        orders:null
      }
    },
    methods: {
      cancelOrder: function(oid,event){
          event.preventDefault();
              var uid=0;
              if(this.$session.has('user')){
                  uid=this.$session.get('user').id;
              }
              axios.post('http://localhost:33445/cancelorder', 
              {
                            uid: uid,
                            oid: oid
                        },
                        {
                   headers: {'Access-Control-Allow-Origin': '*'}
              })
                .then(response => {
                            if(response.data.status != 'SUCCESS'){
                                alert('Error Ocurred during request to server');
                            }else{
                            this.$session.set('user',response.data.user);
                            if(this.$session.has('user')){
                            this.$store.commit('updateCartCount',this.$session.get('user'));
                            this.$store.commit('setLoginStatus', this.$session.get("user"));
                            this.orders=this.$session.get('user').orders;
                            }
                            }
                        })
                        .catch((error) =>{
                            console.log(error);
                        });
          
      }
    },
    computed: {
      orderedOrders: function () {
    return _.orderBy(this.orders, 'id','desc');
  }
    }
}


</script>

<style scoped>
.order-view {
}
</style>
