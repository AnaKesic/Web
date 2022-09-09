<template>
    <div>
    
    <Logedbar></Logedbar>
    <v-toolbar  dark
    
    dense
    flat>
  

    <v-spacer></v-spacer>

  <v-btn  >
       Početna strana
    </v-btn>
    <v-btn  >
       Prijavi trening
    </v-btn>
    <v-btn @click="Treninzi" >
       Moji treninzi
    </v-btn>
    <v-btn  >
       Kupi članarinu
    </v-btn>
    <v-btn  @click="ProfilMode" >
       Moj profil 
    </v-btn>
    

   
    
  </v-toolbar>



<template v-if="pocetna">
   <Card></Card>
</template>
<template v-if="profil">
   <Profsettings :id=idd ></Profsettings>
</template>

<template v-if="treninzi">
   <Kupactreninzi></Kupactreninzi>
</template>

 
    </div>
</template>
undefined
<script>






undefined
undefined
undefined
module.exports={
  
  name:'Administrator',
  data(){
        return{
            idd: this.$route.params.username,
            profil:false,
            pocetna:true,
            treninzi:false,
            clanarina:false,

            prijavitrening:false
         
        }
},
 
  methods:{
      ProfilMode(){
        this.profil=true,
         this.pocetna=false,
         this.treninzi=false,
         this.clanarina=false,

         this.prijavitrening=false
         
         
      },
      Treninzi(){
         console.log("anas")
         this.profil=false,
         this.pocetna=false,
         this.treninzi=true,
         this.clanarina=false,

         this.prijavitrening=false
         
      }
   }
   }



</script>