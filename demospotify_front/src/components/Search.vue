<template>
  <div>
	  <div class="search">
			<input type="text" v-model='criteria' />
			<button v-on:click="search">Recherche</button>
	  </div>
	  <div class="grid">
			<div v-for="album in albums" v-model="albums" class="item">
				<div>
					<img v-bind:src="album.images[0].url" class="vignette"/>
				</div>

				<div>
					<span>{{album.name}}</span>
				</div>
				<div>
					<div v-if="album.inAlbumLibrary">
						<button v-on:click="deleteFromLibrary(album)">Retirer de la bibliothèque</button>
					</div>
					<div v-else>
						<button v-on:click="addToLibrary(album)">Ajouter dans la bibliothèque</button>
					</div>
				</div>
				<card/>
			</div>
	  </div>
  </div>
</template>

<script>

export default {
  name: 'Search',
  data: function () {
        return{
            criteria: " ",
			albums: null,
        }
    },
	
  methods: {
	search: function(){
			 
		this.$axios
			.get('http://localhost:8080/demospotify/search/' + this.criteria)
			.then((response) => {
				this.albums = response.data;
				console.log(this.albums);
			}, (error)  =>  {
				console.log(error);
			})
	},
	addToLibrary: function(album){
		this.$axios
			.get('http://localhost:8080/demospotify/library/add/' + album.id)
			.then((response) => {
				console.log(album);
				album.inAlbumLibrary = !album.inAlbumLibrary;
			}, (error)  =>  {
				console.log(error);
			})
	},
	deleteFromLibrary: function(album){
			 
		this.$axios
			.get('http://localhost:8080/demospotify/library/delete/' + album.id)
			.then((response) => {
				console.log(album);
				album.inAlbumLibrary = !album.inAlbumLibrary;
			}, (error)  =>  {
				console.log(error);
			})
	}
  }
}
</script>

<style scoped>
    .grid {
        display: flex;
        flex-flow: wrap;
        justify-content: space-between;
    }
    .item {
        flex: 0 0 30%;
        margin: 16px;
    }
	
	.vignette {
		height: 320px;
		width: 320px,
	}
</style>
