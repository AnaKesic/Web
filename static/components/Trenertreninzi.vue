<template>
    
    <div>
     <input type="search" style="background:lightgray" placeholder="Sportski Objekat(naziv)" id="objekat" v-model="search_params.objekatGdePripada"/>
     
     <select  style=" background:lightgray" v-model="search_params.tipTreninga">
                 <option value="SVI">SVI</option>
                 <option value="GRUPNI">GRUPNI</option>
                 <option value="PERSONALNI">PERSONALNI</option>
                 <option value="TERETANA">TERETANA</option>
                 
              
         </select>
        
               
         <v-btn color=" lighten-2" dark v-on:click="buttonClickSearch">Pretrazi</v-btn>
     <v-data-table :headers="headers" :items="treninzi" >
       <template v-slot:item.action="{ item }">
     <v-btn>Otkazi</v-btn>
   </template>
     </v-data-table>
     
 
 </div>
     
 
 
 
 
 
       
     
      
 
 </template>
 <script>
 undefined
 module.exports = {
   name: 'Trenertreninzi',
   props:{
       id:String
   },
  mounted() {
       this.defineUser()
      
       },
   data(){
       return{
         search_params:{
             objekatGdePripada: '',
             tipTreninga:'SVI'
             
         },
           User:{},
           korisnickoIme:'',
           treninzi:[],
           headers: [
       { text: 'Naziv',value:'naziv'},
       { text: 'Tip',value:'tipTreninga' },
       { text: 'Trajanje',value:'trajanje'},
       { text: 'Opis',value:'opis'},
       { text: 'Sportski Objekat',value:'objekatGdePripada'},
       { text: "Otkazivanje", value: "action" }
       
       
     ]
            
       }
       },
   methods:{
       defineUser(){
           axios.get("http://localhost:8080/rest/korisnk/getById/"+this.id)
           .then(r=>{
               
               console.log("tanja")
               this.User=r.data
               this.korisnickoIme=this.User.korisnickoIme
               this.ucitajTreninge()
           
           }
           )
       },
       ucitajTreninge(){
           axios.get('rest/trening/getTrenerTreninzi/'+this.korisnickoIme)
           .then(r =>
               {
                       
                       console.log(r.data)
                       this.treninzi = r.data;
                       
                       
                       
                   
               }
           )	
       },
       buttonClickSearch(){
         axios.get("http://localhost:8080/rest/trening/search",{params:{
             objekatGdePripada: this.search_params.objekatGdePripada,
             tipTreninga: this.search_params.tipTreninga
                  
           }} )
             .then(r => {
               this.treninzi= r.data
               console.log(this.treninzi)
             })
       }
   }
 }
 </script>