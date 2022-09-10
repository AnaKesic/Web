<template>
    <div>
    
    <Logedbar></Logedbar>
    <v-toolbar  dark
    
    dense
    flat>
  

    <v-spacer></v-spacer>

  <v-btn  @click="tren" >
    Treninzi
    </v-btn>
    <v-btn  @click="it">
       Istorija treninga
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
   <v-row justify="center">
   <v-btn color="red"  @click="nazad">Nazad</v-btn>
   </v-row>
</template>
<template v-if="istorija">
    <v-row justify="center">
   <v-btn color="red"  @click="nazad">Nazad</v-btn>
   </v-row>
</template>
<template v-if="treninzii">
    <Trenertreninzi :id=idd></Trenertreninzi>
  <v-row justify="center">
   <v-btn color="red" @click="nazad">Nazad</v-btn>
   </v-row>
</template>


</div>
</template>
undefined
<script>






undefined
undefined
undefined
module.exports={
  
  name:'Trener',
  data(){
        return{
            idd: this.$route.params.username,
            pocetna:true,
            istorija:false,
            treninzii:false,
            profil:false
            
        }
},
 
  methods:{
      ProfilMode(){
        this.pocetna=false,
        this.istorija=false,
        this.komentari=false,
        this.profil=true,
        this.treninzii=false
      },
      it(){
        this.pocetna=false,
        this.istorija=true,
        this.komentari=false,
        this.profil=false,
        this.treninzii=false

      },
      tren(){
        this.pocetna=false,
        this.istorija=false,
        this.komentari=false,
        this.profil=false,
        this.treninzii=true

      },
      nazad(){
        this.pocetna=true,
        this.istorija=false,
        this.komentari=false,
        this.profil=false,
        this.treninzii=false

      }

    
    
      
     
   }
}



</script>