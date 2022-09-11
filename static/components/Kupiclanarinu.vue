<template>
   
 <div>
      
       <v-row>
       <v-col class="pa-6" md="6" xs="12">
          <v-card>
            <v-card-title>
                Mesecni paket
            </v-card-title>
            <v-card-text>
               
                   
                
                        <div>-12 termina</div>
                        
                    
                        <div>-Pristup svim sportskim objektima</div>
                       
                    
                        <div>-Cena:2000 dinara</div>
  
                     
                        <template>
                            <v-row justify="space-around">
                                <v-col cols="auto">
                                <v-dialog
                                    
                                    max-width="600"
                                >
                                    <template v-slot:activator="{ on, attrs }">
                                    <v-btn
                                        color="green"
                                        v-bind="attrs"
                                        v-on="on"
                                    >Kupi</v-btn>
                                    </template>
                                    <template v-slot:default="dialog">
                                    <v-card>
                                        <v-toolbar
                                        color="primary"
                                        dark
                                        >Pregled kupovine</v-toolbar>
                                        <v-card-title>
                                        <div>Standardni mesecni paket</div>
                                        </v-card-title>
                                        <v-card-text>
                                            <div>-12 termina</div>
                        
                    
                                                <div>-Pristup svim sportskim objektima</div>
                                            
                                            
                                                <div>-Cena:2000 dinara</div>
                                        </v-card-text>
                                        <v-card-actions class="justify-end">
                                        <v-btn
                                            color="red"
                                            text
                                            @click="dialog.value = false"
                                        >Odustani</v-btn>
                                        <v-btn
                                            color="green"
                                            text
                                            @click="basicc"
                                        >Plati</v-btn>
                                        </v-card-actions>
                                    </v-card>
                                    </template>
                                </v-dialog>
                                </v-col>

                               
    </v-row>
    </template>

               
           
            </v-card-text>
          </v-card>
        </v-col>
        <v-col  class="pa-6" md="6" xs="12">
            <v-card>
            <v-card-title>
                Godisnji paket
            </v-card-title>
            <v-card-text>
               
                   
                
                        <div>-365 termina</div>
                        
                    
                        <div>-Pristup svim sportskim objektima</div>
                       
                    
                        <div>-Cena:20000 dinara</div>
  
                        <template>
                            <v-row justify="space-around">
                                <v-col cols="auto">
                                <v-dialog
                                    
                                    max-width="600"
                                >
                                    <template v-slot:activator="{ on, attrs }">
                                    <v-btn
                                        color="green"
                                        v-bind="attrs"
                                        v-on="on"
                                    >Kupi</v-btn>
                                    </template>
                                    <template v-slot:default="dialog">
                                    <v-card>
                                        <v-toolbar
                                        color="primary"
                                        dark
                                        >Pregled kupovine</v-toolbar>
                                        <v-card-title>
                                        <div >Godisnji paket</div>
                                        </v-card-title>
                                        <v-card-text>
                                            <div>-365 termina</div>
                                            <div></div>
                    
                                            <div>-Pristup svim sportskim objektima</div>
                                        
                                            <div></div>
                                            <div>-Cena:20000 dinara</div>
                                        </v-card-text>
                                        <v-card-actions class="justify-end">
                                        <v-btn color="red"
                                            text
                                            @click="dialog.value = false"
                                        >Odustani</v-btn>
                                        <v-btn
                                        color="green"
                                            text
                                            @click="godisnja"
                                        >Plati</v-btn>
                                        </v-card-actions>
                                    </v-card>
                                    </template>
                                </v-dialog>
                                </v-col>
                                </v-row>
                                </template>

                      
           
            </v-card-text>
          </v-card>
        </v-col>
        <v-col  class="pa-6" md="6" xs="12">
            <v-card>
            <v-card-title>
                Premium paket
            </v-card-title>
            <v-card-text>
               
                   
                
                        <div>-30 termina</div>
                        
                    
                        <div>-Pristup svim sportskim objektima</div>
                       
                    
                        <div>-Cena:3000 dinara</div>
  
                     
                        <template>
                            <v-row justify="space-around">
                                <v-col cols="auto">
                                <v-dialog
                                    
                                    max-width="600"
                                >
                                    <template v-slot:activator="{ on, attrs }">
                                    <v-btn
                                        color="green"
                                        v-bind="attrs"
                                        v-on="on"
                                    >Kupi</v-btn>
                                    </template>
                                    <template v-slot:default="dialog">
                                    <v-card>
                                        <v-toolbar
                                        color="primary"
                                        dark
                                        >Pregled kupovine</v-toolbar>
                                        <v-card-title>
                                        <div >Premium paket</div>
                                        </v-card-title>
                                        
                                            <v-card-text>
                                                <div>-30 termina</div>
                        
                    
                                                <div>-Pristup svim sportskim objektima</div>
                                            
                                            
                                                <div>-Cena:3000 dinara</div>
                                            </v-card-text>
                                            <v-card-actions class="justify-end">
                                        <v-btn
                                            color="red"
                                            text
                                            @click="dialog.value = false"
                                        >Odustani</v-btn>
                                        <v-btn
                                            color="green"
                                            text
                                            @click="premium"
                                        >Plati</v-btn>
                                        </v-card-actions>
                                    </v-card>
                                    </template>
                                </v-dialog>
                                </v-col>
                                </v-row>
                                </template>

               
           
            </v-card-text>
          </v-card>
        </v-col>
        
        </v-row>
</div> 

</template>
<script>




module.exports={
name:'Kupiclanarinu',
data(){
    return{
        
        dialog:false
         


    }
},
//

methods:{
   
    basicc(){
       console.log(this.$route.params.username)
    
                 var Clanarina = {
                    "id": "basicpackg",
                     "kupac":  this.$route.params.username
                    };
                 axios.post("http://localhost:8080/rest/clanarina/add",Clanarina)
                     .then(r=>{
                         console.log(r.data)
                         this.$emit('close-addclan', false);
                     })
    },
    godisnja(){
         var Clanarina={
              "id": "godispackg",
              "kupac":  this.$route.params.username
             };
         axios.post("http://localhost:8080/rest/clanarina/add",Clanarina)
             .then(r=>{
                 console.log(r.data)
                 this.$emit('close-addclan', false);
             })

    },
    premium(){
        var Clanarina={
             "id": "premipackg",
             "kupac":  this.$route.params.username
           };
        axios.post("http://localhost:8080/rest/clanarina/add",Clanarina)
            .then(r=>{
                console.log(r.data)
                this.$emit('close-addclan', false);
            })
    }
 }
}
</script>
<style>
</style>
