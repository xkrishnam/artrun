import Vue from "vue";
import App from "./App.vue";
import VueRouter from "vue-router";
import ArtMainContent from "./components/ArtMainContent";
import loginPage from "./components/loginPage";
import ArtSignup from "./components/artSignup";
import SingleItem from "./components/SingleItem";
import VueSession from "vue-session";
import CartView from "./components/CartView";
import PlaceOrder from "./components/PlaceOrder";
import OrderView from "./components/OrderView";
import OrderDetailView from "./components/OrderDetailView";
import UploadPainting from "./components/UploadPainting";
import globals from "./ar-config.json";
import _get from "lodash/get";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import store from "./store";

Vue.prototype.$g = (key) => {
  let val = _get(globals, key, "");
  if (!val) console.warn(key, " is empty in $g");
  return val || key;
};

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
    { path: "/myorders", component: OrderView },
    { path: "/vieworder/:oid", component: OrderDetailView },
    { path: "/uploadpainting", component: UploadPainting },
    { path: "*", redirect: "/" },
  ],
});

new Vue({
  router,
  render: (h) => h(App),
  store,
  mounted: function() {
    console.log(this.$session.get("user"));
    this.$store.commit("initData");
    this.$store.commit("updateCartCount", this.$session.get("user"));
    this.$store.commit("setLoginStatus", this.$session.get("user"));
  },
}).$mount("#app");
