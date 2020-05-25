<template>
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
              <tbody>
                <tr v-bind:key="painting.id" v-for="painting in paintings">
                  <td class="product-thumb">
                    <img
                      width="80px"
                      height="auto"
                      :src="require('../assets/media/'+painting.id+'.jpg')"
                      alt="image description"
                    />
                  </td>
                  <td class="product-details">
                    <h3 class="title">{{painting.title}}</h3>
                  </td>
                  <td class="product-category">
                    <span class="categories">{{painting.price}}INR</span>
                  </td>
                  <td class="action" data-title="Action">
                    <div class>
                      <ul class="list-inline justify-content-center">
                        <li class="list-inline-item">
                          <router-link
                            :to="'/art/'+painting.id"
                            data-toggle="tooltip"
                            data-placement="top"
                            title="Edit"
                            class="edit"
                          >
                            <i class="fa fa-eye"></i>
                          </router-link>
                        </li>
                        <li class="list-inline-item">
                          <a
                            data-toggle="tooltip"
                            data-placement="top"
                            title="Delete"
                            class="delete"
                            v-on:click="removeFromCart(painting.id, $event)"
                          >
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

<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
