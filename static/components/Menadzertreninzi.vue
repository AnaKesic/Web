<template>
    
        <v-data-table :headers="headers" :items="treninzi" hide-default-footer>
            <template v-slot:item.action="{ item }">
            </template>
        </v-data-table>
        
    
  
    
  

          
        
         
   
  </template>
  <script>
  
  
  undefined
  module.exports = {
      name: 'Menadzertreninzi',
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
              treninzi:[],
              headers: [
          { text: 'Naziv',value:'naziv'},
          { text: 'Tip',value:'tipTreninga' },
          { text: 'Trajanje',value:'trajanje'},
          { text: 'Opis',value:'opis'},
          { text: 'Trener',value:'nazivTrenera'}
          
          
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
                  this.ucitajTrenere()
              
              }
              )
          },
          ucitajTrenere(){
              axios.get('rest/trening/getTreninzi/'+this.nazivSpObj)
              .then(r =>
                  {
                          
                          console.log(r.data)
                          this.treninzi = r.data;
                          
                          
                          
                      
                  }
  
              )	
          }
      }
  }
  
  </script>