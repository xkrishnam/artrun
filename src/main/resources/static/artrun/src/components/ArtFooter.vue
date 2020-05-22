<template>
  <!-- Footer Bottom -->
  <footer class="footer-bottom">
    <!-- Container Start -->
    <div class="container">
      <div class="row">
        <div class="col-sm-6 col-12">
          <!-- Copyright -->
          <div class="copyright">
            <p>
              Copyright © {{ currentYear }}. All Rights Reserved by {{arcompany}}
            </p>
          </div>
        </div>
        <div class="col-sm-6 col-12"></div>
      </div>
    </div>
    <!-- Container End -->
    <!-- To Top -->
    <div class="top-to">
      <a id="top" class href="#">
        <i class="fa fa-angle-up"></i>
      </a>
    </div>
  </footer>
</template>

<script>
export default {
  name: "ArtFooter",
  props: {
    msg: String,
    arcompany: String
  },
  data() {
    return {
      currentYear: new Date().getFullYear()
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
