<template>
  <div id="app">
    <ArtHeader
      msg="Welcome to my Vue.js App"
      v-bind:quantity="this.$store.state.count"
      @updateCartQuantity="quant = $event"
    />
    <SearchBar />
    <router-view></router-view>
    <ArtFooter arcompany="artrun" />
  </div>
</template>

<script>
import ArtHeader from "./components/ArtHeader";
import ArtFooter from "./components/ArtFooter";
import SearchBar from "./components/SearchBar";

export default {
  name: "App",
  data() {
    return {
      quant: 0
    };
  },
  components: {
    ArtHeader,
    ArtFooter,
    SearchBar
  }
};
</script>

<style>
/* @import "./assets/plugins/bootstrap/css/bootstrap.min.css";
@import "./assets/plugins/bootstrap/css/bootstrap-slider.css"; */
@import "./assets/plugins/font-awesome/css/font-awesome.min.css";
@import "./assets/plugins/slick-carousel/slick/slick.css";
@import "./assets/plugins/slick-carousel/slick/slick-theme.css";
@import "./assets/plugins/fancybox/jquery.fancybox.pack.css";
@import "./assets/plugins/jquery-nice-select/css/nice-select.css";
@import "./assets/css/style.css";
</style>
