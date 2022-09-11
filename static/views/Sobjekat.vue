<template>
   
    <div>
       
        
     <v-card
     class="mx-auto my-12"
     max-width="500"
   >
 
     <v-img
       height="250"
       :src="objekat.logoObjekta"
     ></v-img>
 
     <v-card-title class="justify-center">{{objekat.naziv}}</v-card-title>
     <v-divider class="mx-4"></v-divider>
     
 
     <v-card-text>
       <div class="my-4 text-subtitle-1">
         {{objekat.tip}}
       </div>
 
       
     </v-card-text>
 
     
     <v-layout pa-2>
                     <v-icon>
                         mdi-clock
                     </v-icon>
                    <v-layout v-bind:class="getClass(objekat.status)">
                     {{objekat.pocetakRadnogVremena}}-{{objekat.krajRadnogVremena}}
                     {{objekat.status}}
                     </v-layout>
                 </v-layout>
 
     <v-layout pa-2>
                  <v-icon>
                         mdi-map-marker
                     </v-icon>
                    
                     {{objekat.lokacija?.adresa}}
                     
                 </v-layout>
     <v-layout pa-3>
         <v-row
         align="center"
         class="mx-0"
       >
         <v-rating
         :value=objekat.prosecnaOcena
           color="amber"
           dense
           half-increments
           readonly
           size="14"
         ></v-rating>
 
         <div class="grey--text ms-4">
             {{objekat.prosecnaOcena}}
         </div>
       </v-row>
     </v-layout>
     
   </v-card>
   <v-data-table :headers="headers" :items="treninzi" >
    </v-data-table>
   
    </div>
     
     
  
 </template>
 <script>
 module.exports = {
     name: 'Sobjekat',
     props:{
        kor:String
    },
    
    mounted() {
         this.ucitaj(),
         this.ucitajTreninge()
        
         },
     data(){
         return{
            
            treninzi:[],
             objekat:{},
             headers: [
             { text: 'Naziv',value:'naziv'},
      { text: 'Tip',value:'tipTreninga' },
      { text: 'Trajanje',value:'trajanje'},
      { text: 'Opis',value:'opis'},
      { text: 'Trener',value:'nazivTrenera'},
      
         ]
      
              
 
         }
 
         },
     methods:{
         ucitaj(){
             axios
             .get('rest/ucitajobjmen/'+ this.$route.params.naziv)
             .then(response =>
                 {
                         
                         console.log(response.data)
                         this.objekat = response.data;
                         
                         
                     
                 }
 
             )	
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
     ucitajTreninge(){
        axios.get('rest/trening/getTreninzi/'+this.$route.params.naziv)
              .then(r =>
                  {
                          
                          console.log(r.data)
                          this.treninzi = r.data;
                          
                      
                  
              }

          )	
      }
         
        
        
        
  }}
 </script>
 
 

