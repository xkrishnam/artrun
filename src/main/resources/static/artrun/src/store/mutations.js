export default {
  updateCartCount(state, user) {
    if (user) {
      var quant = user.cart.paintings ? user.cart.paintings.length : 0;
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
      state.userLogged = false;
    }
  },
};
