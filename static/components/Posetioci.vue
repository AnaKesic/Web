<template>
    <v-data-table :headers="headers" :items="kupci" hide-default-footer>
  
  </v-data-table>
          
        
         
   
  </template>
  <script>
  undefined
  module.exports = {
      name: 'Posetioci',
      props:{
          id:String
      },
     mounted() {
          this.defineUser()
         
          },
      data(){
          return{
              User:{},
              nazivSpObj:'',
              kupci:[],
              headers: [
          { text: 'Korisnicko ime',value:'kIme'},
          { text: 'Ime',value:'ime' },
          { text: 'Prezime',value:'prezime'}
          
        ]
               
          }
          },
      methods:{
          defineUser(){
              axios.get("http://localhost:8080/rest/korisnk/getById/"+this.id)
              .then(r=>{
                  
                  console.log("tanja")
                  this.User=r.data
                  this.nazivSpObj=this.User.nazivSpObj
                  this.ucitajKupce()
              
              }
              )
          },
          ucitajKupce(){
              axios.get('rest/korisnik/getKupci/'+this.nazivSpObj)
              .then(r =>
                  {
                          
                          console.log(r.data)
                          this.kupci = r.data;
                          
                          
                          
                      
                  }
              )	
          }
      }
  }
  </script>