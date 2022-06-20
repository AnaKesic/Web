<template>

  <v-card 
    class="mx-auto"
    max-width="900"
    outlined
  >
  <div style="margin: auto; padding-left: 20px;">
    <input type="search" style="background:lightgray" placeholder="Pretraga po nazivu" id="naziv" v-model="naziv"></input>
    <input type="search" style="background:lightgray" placeholder="Pretraga po tipu" id="tip" v-model="tip"></input> 
    <input type="search" style="background:lightgray" placeholder="Pretraga po lokaciji" id="lokacija" v-model="lokacija"></input>
    <input type="search" style="background:lightgray" placeholder="Pretraga po prosecnoj oceni" id="prosecnaOcena" v-model="prosecnaOcena"></input>
    <v-btn color=" lighten-2" dark v-on:click="buttonClickSearch">Pretrazi</v-btn>
  </div>
  <div v-for="sportskiObjekat in sportskiObjekti">
    <v-list-item three-line >
      <v-list-item-content>
        <div class="text-overline mb-4">
          SPORTSKI OBJEKAT
        </div>
        <v-list-item-title  v-bind:key="sportskiObjekat.id" class="text-h5 mb-1">
         <div>
             {{sportskiObjekat.naziv}}
           </div>  
        </v-list-item-title>
        <v-list-item-subtitle> {{sportskiObjekat.tip}}</v-list-item-subtitle>
        <v-list-item-subtitle> {{sportskiObjekat.sadrzaj}}</v-list-item-subtitle>
        <v-list-item-subtitle> {{sportskiObjekat.status}}</v-list-item-subtitle>
        <v-list-item-subtitle> {{sportskiObjekat.lokacija.adresa}}</v-list-item-subtitle>
        <v-list-item-subtitle> {{sportskiObjekat.pocetakRadnogVremena}}</v-list-item-subtitle>
        <v-list-item-subtitle> {{sportskiObjekat.krajRadnogVremena}}</v-list-item-subtitle>
        <v-list-item-subtitle> Prosecna ocena:{{sportskiObjekat.prosecnaOcena}}</v-list-item-subtitle>
      </v-list-item-content>

      <img 
         max-height="150"
        max-width="250"
        
        color="grey"
        v-bind:src="sportskiObjekat.logoObjekta"
     ></img>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
      >
        Vise detalja
      </v-btn>
    </v-card-actions>
    </div>
  </v-card>
</template>
<script>
module.exports={
   name:"Card",
   data(){
     return {
        sportskiObjekti:[],
         naziv: '',
            tip: '',
            lokacija: '',
            prosecnaOcena: null,
     }


   },
   mounted() {
    this.buttonClickGetAll(),
    console.log(this.data)
   },
    methods: {
        buttonClickGetAll() {
         axios.get("http://localhost:8080/rest/sportski-objekat/get-all")
            .then(r => {
              this.sportskiObjekti= r.data
              console.log(this.sportskiObjekti)
            })
        }, 
        buttonClickSearch() {
          axios.get("http://localhost:8080/rest/sportski-objekat/search/" + this.naziv + "/" + this.tip + "/" + this.lokacija + "/" + this.prosecnaOcena)
            .then(r => {
              this.sportskiObjekti= r.data
              console.log(this.sportskiObjekti)
            })
        },
}}
</script>