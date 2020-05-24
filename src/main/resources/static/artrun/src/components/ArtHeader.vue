<template>
  <section>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <nav class="navbar navbar-expand-lg navbar-light navigation">
            <a class="navbar-brand" href="index.html">
              <img src="../assets/images/ar-logo.png" alt />
            </a>
            <button
              class="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ml-auto main-nav">
                <li class="nav-item active">
                  <router-link class="nav-link" to="/">Home</router-link>
                </li>
              </ul>
              <ul class="navbar-nav ml-auto mt-10">
                <li class="nav-item" v-if="this.$store.state.userLogged">
                  <router-link to="/login" class="nav-link login-button">Upload Paintings</router-link>
                </li>
                <li class="nav-item" v-if="this.$store.state.userLogged">
                  <router-link to="/myorders" class="nav-link login-button">My Orders</router-link>
                </li>
                <li class="nav-item" v-if="this.$store.state.userLogged">
                  <router-link to="/login" class="nav-link login-button">My Profile</router-link>
                </li>
                <li class="nav-item" v-if="this.$store.state.userLogged">
                  <a @click="logout" href class="nav-link login-button">Logout</a>
                </li>
                <li class="nav-item" v-if="!this.$store.state.userLogged">
                  <router-link to="/login" class="nav-link login-button">Login</router-link>
                </li>
                <li class="nav-item" v-if="!this.$store.state.userLogged">
                  <router-link to="/signup" class="nav-link login-button">Sign up</router-link>
                </li>
                <li class="nav-item">
                  <router-link class="nav-link text-white add-button" to="/cart">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">{{quantity}}</span>
                  </router-link>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "ArtHeader",
  props: {
    msg: String,
    quantity: Number
  },
  methods: {
    logout: function(event) {
      event.preventDefault();
      this.$session.clear();
      this.$store.commit("setLoginStatus", this.$session.get("user"));
      this.$store.commit("updateCartCount", this.$session.get("user"));
      this.$router.push("/");
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
