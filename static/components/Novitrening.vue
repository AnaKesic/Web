<template>



      
     
    
  	
</template>
<script>
    undefined
    module.exports = {
      name: 'Novitrening',
      
     mounted() {
          this.ucitajTrenere()
         
          },
      data(){
          return{
            
              treneri:[],
           
          }
    
          },
      methods:{
          
        ucitajTrenere(){
            axios.get('rest/korisnik/getTreneri')
              .then(r =>
                  {
                          
                          console.log(r.data)
                          this.treneri = r.data                          
                          
                          
                      
                  }
    
              )	
          }
      }
    }
    
    </script>