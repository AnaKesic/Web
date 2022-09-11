<template>
 
    <div>
     <v-layout align-center justify-center>
     <div style="margin: auto; padding-all: 20px;" class="center">
  
      <input type="search" style="background:lightgray" placeholder="Naziv objekta" id="naziv" v-model="search_params.naziv"/>
      <select  style=" background:lightgray" v-model="search_params.tip">
                  <option value="SVI">SVI</option>
                  <option value="BAZEN">BAZEN</option>
                  <option value="TERETANA">TERETANA</option>
                  <option value="SPORTSKI_CENTAR">SPORTSKI CENTAR</option>
          <option value="PLESNI_STUDIO">PLESNI STUDIO</option>
          </select>   
      <input type="search" style="background:lightgray" placeholder="Lokacija" id="lokacija" v-model="search_params.lokacija"/>
      <input type="search" style="background:lightgray" placeholder="" id="prosecnaOcena" v-model="search_params.prosecnaOcena"/>
      <input type="checkbox" v-model="search_params.samoOtvoreni">Samo otvoreni objekti</input>
      <v-btn color=" lighten-2" dark v-on:click="buttonClickSearch">Pretrazi</v-btn>
  
     </div>		
      <div style="margin: left; padding-all: 20px;" class="left">
       <h>Sortiraj:</h>
                  <select style="background:lightgray" name="tipSortiranja" v-on:change="sort" v-model="tipSortiranja">
                        <option value="tip">Tip</option>
                      <option value="naziv">Naziv</option>
                      <option value="lokacija">Lokacija</option>
                      <option value="prosecnaOcena">Ocena</option>
                  </select>
                  <select style="background:lightgray" name="smerSortiranja" v-on:change="sort" v-model="smerSortiranja">
                  <option value="smer">Smer</option>
                      <option value="rastuce">Rastuce</option>
                      <option value="opadajuce">Opadajuce</option>
                  </select>
      </div>
     </v-layout>
      <v-container >
        <v-layout row wrap >
          <v-flex
            xs12 md6
            v-for="sportskiObjekat in sportskiObjekti" :key=sportskiObjekat.id>
          
            <v-card class="ma-6 " v-on:click="prikazi(sportskiObjekat)" >
            
            <v-layout pa-2>
                    <v-flex xs12 md6  >
                      
                          <v-card-title>{{sportskiObjekat.naziv}}</v-card-title>
                          <v-card-subtitle> {{sportskiObjekat.tip}} </v-card-subtitle>
                    
                     </v-flex>
  
  
             <v-flex  xs12 md6  align-end>
              <v-layout xs12 md3 >
              <v-img 
                :src="sportskiObjekat.logoObjekta"
                height="150"
                width="150"
                justify="center"
                align="center"
  
                
              />
              </v-layout>
            </v-flex>
          </v-layout >
            
              <v-card-text>
                  <v-layout pa-2>
                      <v-icon>
                          mdi-clock
                      </v-icon>
                     <v-layout v-bind:class="getClass(sportskiObjekat.status)">
                      {{sportskiObjekat.pocetakRadnogVremena}}-{{sportskiObjekat.krajRadnogVremena}}
                      {{sportskiObjekat.status}}
                      </v-layout>
                  </v-layout>
                  <v-layout pa-2>
                   <v-icon>
                          mdi-map-marker
                      </v-icon>
                     
                      {{sportskiObjekat.lokacija?.adresa}}
                     
                  </v-layout>
                 <v-layout pa-3>  
                 <v-row
                      align="center"
                      class="mx-0"
                              >
                              
            <v-rating
                        :value=sportskiObjekat.prosecnaOcena
                        color="amber"
                        dense
                        half-increments
                        readonly
                        size="14"
                    ></v-rating>
                    <v-layout pa-2>
                    <div class="grey--text ms-4">
                        {{sportskiObjekat.prosecnaOcena}}
                    </div>
                    </v-layout>
                                        <template>
                                                <v-row justify="center">
                                                    <v-dialog
                                                    v-model="dialog"
                                                    persistent
                                                    max-width="290"
                                                    >
                                                    <template v-slot:activator="{ on, attrs }">
                                                        <v-btn
                                                        color="primary"
                                                        dark
                                                        v-bind="attrs"
                                                        v-on="on"
                                                        @click="slobodniTermini(sportskiObjekat.naziv)"
                                                        >
                                                        Zakaži trening
                                                        </v-btn>
                                                    </template>
                                                    <v-card>
                                                        <v-card-title class="text-h5">
                                                        Use Google's location service?
                                                        </v-card-title>
                                                        <v-card-text>Let Google help apps determine location. This means sending anonymous location data to Google, even when no apps are running.</v-card-text>
                                                        <v-card-actions>
                                                        <v-spacer></v-spacer>
                                                        <v-btn
                                                            color="green darken-1"
                                                            text
                                                            @click="dialog = false"
                                                        >
                                                            Odustani
                                                        </v-btn>
                                                        <v-btn
                                                            color="green darken-1"
                                                            text
                                                            @click="dialog = false"
                                                        >
                                                            Zakaži
                                                        </v-btn>
                                                        </v-card-actions>
                                                    </v-card>
                                                    </v-dialog>
                                                </v-row>
                                                </template>
                  </v-row>
                  </v-layout>
              
             </v-card-text>
             
            </v-card>
         
          </v-flex>
        </v-layout>
      </v-container>
      
   </div>
   
  </template>
  
  <script>
  module.exports={
     name:"Cardkupac",
     data(){
       return {
          sportskiObjekti:null,
          dialog:false,
          search_params:{
           naziv: '',
              tip: 'SVI',
              lokacija: '',
              prosecnaOcena: 0,
              samoOtvoreni: false},
              tipSortiranja:"tip",
              smerSortiranja:"smer",
              prikaztrening:false,
             
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
            
            axios.get("http://localhost:8080/rest/sportski-objekat/search",{params:{
              naziv: this.search_params.naziv,
                   tip: this.search_params.tip,
                   lokacija: this.search_params.lokacija,
                   prosecnaOcena: this.search_params.prosecnaOcena,
           samoOtvoreni: this.search_params.samoOtvoreni
            }} )
              .then(r => {
                this.sportskiObjekti= r.data
                console.log(this.sportskiObjekti)
              })
          },
          sort: function(){
              if(this.tipSortiranja == "naziv"){
                  if(this.smerSortiranja=="rastuce" || this.smerSortiranja=="smer"){
                      this.sportskiObjekti.sort((a, b) => (a.naziv.toUpperCase() > b.naziv.toUpperCase()) ? 1 : ((b.naziv.toUpperCase() > a.naziv.toUpperCase()) ? -1 : 0));
                  }else{
                      this.sportskiObjekti.sort((b, a) => (a.naziv.toUpperCase() > b.naziv.toUpperCase()) ? 1 : ((b.naziv.toUpperCase() > a.naziv.toUpperCase()) ? -1 : 0));
                  }
              } else if(this.tipSortiranja == "lokacija"){
                  if(this.smerSortiranja=="rastuce" || this.smerSortiranja=="smer"){
                      this.sportskiObjekti.sort((a, b) => (a.lokacija.adresa.toUpperCase() > b.lokacija.adresa.toUpperCase()) ? 1 : ((b.lokacija.adresa.toUpperCase() > a.lokacija.adresa.toUpperCase()) ? -1 : 0));
                  }else{
                      this.sportskiObjekti.sort((b, a) => (a.lokacija.adresa.toUpperCase() > b.lokacija.adresa.toUpperCase()) ? 1 : ((b.lokacija.adresa.toUpperCase() > a.lokacija.adresa.toUpperCase()) ? -1 : 0));
                  }
              } else if(this.tipSortiranja == "prosecnaOcena"){
                  if(this.smerSortiranja=="rastuce" || this.smerSortiranja=="smer"){
                      this.sportskiObjekti.sort((a, b) => (a.prosecnaOcena > b.prosecnaOcena) ? 1 : ((b.prosecnaOcena > a.prosecnaOcena) ? -1 : 0));
                  }else{
                      this.sportskiObjekti.sort((b, a) => (a.prosecnaOcena > b.prosecnaOcena) ? 1 : ((b.prosecnaOcena > a.prosecnaOcena) ? -1 : 0));
                  }
              }
  
          },
          getClass(nesto){
              console.log(nesto)
             if(nesto=="OTVORENO"){
               return 'green--text'
             }
             else{
              return 'red--text'
             }
      },
       prikazi: function(sportskiObjekat){
              window.location.href = "#/jedanSportskiObjekat/"+sportskiObjekat.naziv;
          },
          Zakazitrening(){
            this.prikaztrening=true
          },
          slobodniTermini(obj){
            console.log(obj)
           
           
             var p=obj
             axios.get("http://localhost:8080/rest/sportski-objekat/getbynaziv", p)
               .then(r => {
               console.log(r.data)
                console.log("nesto")
          })
          }
  }}
  </script>