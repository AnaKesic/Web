<template>
    
   <div>
    
    <v-data-table :headers="headers" :items="treninzi" >
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
        
          User:{},
          korisnickoIme:'',
          treninzi:[],
          headers: [
      { text: 'Naziv',value:'naziv'},
      { text: 'Tip',value:'tipTreninga' },
      { text: 'Trajanje',value:'trajanje'},
      { text: 'Opis',value:'opis'},
      { text: 'Sportski Objekat',value:'objekatGdePripada'},
      { text: "", value: "action" }
      
      
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
      }
  }
}

</script>