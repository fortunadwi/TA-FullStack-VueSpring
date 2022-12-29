<template>
  <div>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css"
    />
    <div id="viewport">
      <!-- Sidebar -->
      <div id="sidebar">
        <header class="mt-4">
          <!-- <a href="#">E - KTP</a> -->
          <h3 class="text-white p-3">E - KTP</h3>
        </header>
        <ul class="nav mt-5">
          <li class="m-4">
            <router-link to="/Home" class="zmdi zmdi-home">
              &nbsp;&nbsp;&nbsp;&nbsp;Home
            </router-link>
          </li>

          <li class="mt-2 ml-4">
            <router-link to="/AddKK" class="zmdi zmdi-account-add">
              &nbsp;&nbsp;&nbsp;&nbsp;Tambah KK
            </router-link>
          </li>



          <div class="d-flex" style="margin-top: 23rem">
            <li class="m-4 mt-3">
              <router-link to="/login" class="zmdi zmdi-mail-reply">
                &nbsp;&nbsp;&nbsp;&nbsp;Logout
              </router-link>
            </li>
          </div>
        </ul>
      </div>
      <!-- Content -->
      <div id="content">
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <ul class="nav navbar-nav navbar-right"></ul>
          </div>
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500");

body {
  overflow-x: hidden;
  font-family: "Roboto", sans-serif;
  font-size: 16px;
}

/* Toggle Styles */

#viewport {
  padding-left: 250px;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#content {
  width: 100%;
  position: relative;
  margin-right: 0;
}

/* Sidebar Styles */

#sidebar {
  z-index: 1000;
  position: fixed;
  left: 250px;
  width: 250px;
  height: 100%;
  margin-left: -250px;
  overflow-y: auto;
  background: #165e3f;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#sidebar header {
  background-color: #263238;
  font-size: 20px;
  line-height: 52px;
  text-align: center;
}

#sidebar header a {
  color: #fff;
  display: block;
  text-decoration: none;
}

#sidebar header a:hover {
  color: #fff;
}

#sidebar .nav {
}

#sidebar .nav a {
  background: none;
  border-bottom: 1px solid #455a64;
  color: #cfd8dc;
  font-size: 14px;
  padding: 16px 24px;
}

#sidebar .nav a:hover {
  background: none;
  color: #eceff1;
}

#sidebar .nav a i {
  margin-right: 16px;
}
</style>
