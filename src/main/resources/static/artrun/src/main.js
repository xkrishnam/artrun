import Vue from "vue";
import App from "./App.vue";
import VueRouter from "vue-router";
import ArtMainContent from "./components/ArtMainContent";
import loginPage from "./components/loginPage";
import ArtSignup from "./components/artSignup";
import SingleItem from "./components/SingleItem";
import VueSession from "vue-session";
import Vuex from "vuex";
import CartView from "./components/CartView";
import PlaceOrder from "./components/PlaceOrder";
import OrderView from "./components/OrderView";

Vue.use(Vuex);
Vue.use(VueSession);
Vue.use(VueRouter);
Vue.config.productionTip = false;

const router = new VueRouter({
  mode: "history",
  base: __dirname,
  routes: [
    { path: "/", component: ArtMainContent },
    { path: "/login", component: loginPage },
    { path: "/signup", component: ArtSignup },
    { path: "/art/:id", component: SingleItem },
    { path: "/cart", component: CartView },
    { path: "/checkout", component: PlaceOrder },
    { path: "/vieworder", component: OrderView },
    { path: "*", redirect: "/" },
  ],
});

const store = new Vuex.Store({
  state: {
    count: 0,
    loggedin: false,
    guest: false,
    userLogged: false,
  },
  mutations: {
    updateCartCount(state, user) {
      if (user) {
        var quant = user.cart.paintings.length;
        state.count = quant;
      }
    },
    setLoginStatus(state, user) {
      if (user) {
        state.loggedin = true;
        if (user.userType == "guest") {
          state.guest = true;
          state.userLogged = false;
        } else if (user.userType == "user") {
          state.guest = false;
          state.userLogged = true;
        }
      } else {
        state.loggedin = false;
      }
    },
  },
});

new Vue({
  router,
  render: (h) => h(App),
  store: store,
  mounted: function() {
    console.log(this.$session.get("user"));
    this.$store.commit("updateCartCount", this.$session.get("user"));
    this.$store.commit("setLoginStatus", this.$session.get("user"));
  },
}).$mount("#app");
