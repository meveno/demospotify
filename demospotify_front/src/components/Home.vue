<template>
  <div id="app">
	<div class="leftBox">
        <ul>
            <li><router-link to="/search">Recherche</router-link></li>
            <li><router-link to="/library">Bibliothèque</router-link></li>
        </ul>
    </div>
    <div class="rightBox">
        <router-view></router-view>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Home',
  data: function () {
        return{

        }
    },
	
  methods: {
	
  }
}
</script>

<style scoped>

</style>
