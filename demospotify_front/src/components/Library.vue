<template>
  <div>
	  <div class="library">
		<h1>Votre bibliothèque</h1>
	  </div>
	  <div class="grid">
			<div v-for="(album, index) in albums" v-model="albums" class="item">
				<input type="hidden" v-model='criteria' />
				<div>
					<img v-bind:src="album.images[0].url" class="vignette"/>
				</div>

				<div>
					<span>{{album.name}}</span>
				</div>
				<div>
					<div>
						Tags:
						<span v-for="tag in album.tags">
							{{tag.name}}
							&nbsp
						</span>
						<button v-on:click="showAddTag(index)">+</button>
					</div> 
					<div v-show="showAddTagIndex==index">
						<input type="text" v-model="tagAdd" />
						<button v-on:click="addTag(album)">Créer</button>
					</div>
				</div>
				<div>
					<div v-if="album.favoris">
						<img src=".././assets/favoris.jpg" class="iconeFavoris"/>
						<button v-on:click="addOrRemoveFavoris(album)">Enlever le favoris</button>
					</div>
					<div v-else>
						<button v-on:click="addOrRemoveFavoris(album)">Ajouter aux favoris</button>
					</div>
				</div>
				<div>
					<button v-on:click="deleteFromLibrary(album)">Retirer de la bibliothèque</button>
				</div>
				<card/>
			</div>
	  </div>
  </div>
</template>

<script>

	export default {
	  name: 'Library',
	  data: function () {
			return{
				albums: null,
				showAddTagIndex: -1,
				tagAdd: null
			}
		},
		
	  methods: {
		loadLibrary:function(){
			this.$axios
				.get('http://localhost:8080/demospotify/library')
				.then((response) => {
					this.albums = response.data;
					console.log(albums);
				}, (error)  =>  {
					console.log(error);
				})
		},
		deleteFromLibrary: function(album){
			 
			this.$axios
				.get('http://localhost:8080/demospotify/library/delete/' + album.id)
				.then((response) => {
					this.loadLibrary();
				}, (error)  =>  {
					console.log(error);
				})
		},
		addOrRemoveFavoris: function(album){
			 
			this.$axios
				.get('http://localhost:8080/demospotify/library/addOrRemoveFavoris/' + album.id + "/" + album.favoris)
				.then((response) => {
					album.favoris = !album.favoris;
				}, (error)  =>  {
					console.log(error);
				})
		},
		showAddTag: function(index){
			this.showAddTagIndex = index;
		},
		addTag: function(album){
		
			this.$axios
				.get('http://localhost:8080/demospotify/library/addTag/' + album.id + '/' + this.tagAdd)
				.then((response) => {
					this.showAddTagIndex = -1;
					if(this.tagAdd != null && this.tagAdd != "" && this.tagAdd != "null"){
						var newTagName = this.tagAdd.toLowerCase().trim();
						var newTag = {name: newTagName};
						var isExist = false;
						for(var i=0; i<album.tags.length; i++){
							if(album.tags[i].name == newTagName){
								isExist = true;
							}
						}

						if(!isExist){
							album.tags.push(newTag);
						}
					}
				}, (error)  =>  {
					console.log(error);
				})
		}
	  },
	  mounted: function(){
		this.loadLibrary();
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
	
	.iconeFavoris {
		height: 35px;
		width: 35px,
	}
</style>
