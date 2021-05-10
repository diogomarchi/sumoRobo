#include <FB_HTTPClient32.h>
#include <FirebaseJson.h>

#include <FirebaseESP32.h>
#include <FirebaseJson.h>

// BIBLIOTECAS PARA TRABALHAR COM FIREBASE
#include <jsmn.h>
#include "DHT.h"      // biblioteca sensor de temperatura

// BIBLIOTECA PARA TRABALHAR COM NTP SERVER
#include <NTPClient.h>
#include <WiFiUdp.h>

#define WIFI_SSID ""   // SSID DO WIFI
#define WIFI_PASSWORD ""  // SENHA DO WIFI

#define HOST "https://sumorobo-bdc8e-default-rtdb.firebaseio.com/"        // ID DE CONEXÃO COM FIREBASE
#define DBKEY "AIzaSyCjlpCPwUp-vNJW7d8VxOuyGzBtQDPIy5s"     // CHAVE DE CONEXÃO COM FIREBASE

#define PIN_ESQ1 12                // PINO 1 DA RODA ESQUERDA
#define PIN_ESQ2 13                // PINO 2 DA RODA ESQUERDA


#define PIN_DIR1 32                // PINO 1 DA RODA DIREITA
#define PIN_DIR2 33                // PINO 2 DA RODA DIRETIA


FirebaseData firebaseData;        // INSTANCIA DO FIREBASE

int estado_lam = 0;               // variavel que armazena o estado atual da lampada
int estado_bomba = 0;             // variavel que armazena o estado atual da bomba
int estado_ventoinha = 0;         // variavel que armazena o estado atual da ventoinha

WiFiUDP ntpUDP;                   // variavel para conexão via udp com o servidor NTP
NTPClient timeClient(ntpUDP);     // instancia do NTP client

int left = 0;
int rigth = 0;


// FUNCAO DE SETUP 
void setup() {
  delay(500);
  
  Serial.begin(115200);                    // inicia monitor serial
  Serial.println("Iniciando SETUP ");
  
  Serial.println("Iniciando conexão WIFI");
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);    // inicia WIFI com SSID e senha
  
  while (WiFi.status() != WL_CONNECTED) {  // aguarda conexão wifi ser estabelecida
    delay(500);
  }
  Serial.println("Wifi conectado!");
    
  Firebase.begin(HOST, DBKEY);              // inicia conexão com Firebase  
  Serial.println("Iniciado FB");
  
  pinMode(PIN_ESQ1, OUTPUT);                // pino para ativar roda esquerda1
  pinMode(PIN_ESQ2, OUTPUT);                // pino para ativar roda esquerda2
  pinMode(PIN_DIR1, OUTPUT);                // pino para ativar roda direita1
  pinMode(PIN_DIR2, OUTPUT);                // pino para ativar roda direita2
  
}


/* 

  *  controle dos movimentos do carrinho
  */
void loop() {
  
//funcionamento
              
  if(Firebase.getInt(firebaseData, "left_on")){    // verifica a variavel de controle da roda esquerda
    if(firebaseData.dataType() == "int"){          // se o tipo retornado estiver certo          
      left = firebaseData.intData();               // valor retornado
      if(left == 1){                               // se for para virar para a esquerda ou pra frente
        digitalWrite(PIN_ESQ1, 1);                   
        digitalWrite(PIN_ESQ2, 0);                   
      }
      else if(left == -1){                         // se for para virar para a direita ou ré
        digitalWrite(PIN_ESQ1, 0);                   
        digitalWrite(PIN_ESQ2, 1);                   
      }
      else{
        digitalWrite(PIN_ESQ1, 0);                  // se for para ficar parado
        digitalWrite(PIN_ESQ2, 0); 
      }
    }else{
      Serial.println("Data type not int");  
    }
  }else {
    Serial.println("Erro no retrieve");
  }

  if(Firebase.getInt(firebaseData, "rigth_on")){ // verifica a variavel de controle da bomba_agua
    if(firebaseData.dataType() == "int"){        // se o tipo retornado estiver certo         
      rigth = firebaseData.intData();            // valor retornado
      if(rigth == 1){                            // se for para virar para a esquerda ou pra frente
        digitalWrite(PIN_DIR1, 1);                   
        digitalWrite(PIN_DIR2, 0);                   
      }
      else if(rigth == -1){                      // se for para virar para a direita ou ré
        digitalWrite(PIN_DIR1, 0);                   
        digitalWrite(PIN_DIR2, 1);                   
      }
      else{
        digitalWrite(PIN_DIR1, 0);               // se for para ficar parado
        digitalWrite(PIN_DIR2, 0); 
      }
    }else{
      Serial.println("Data type not int");  
    }
  }else {
    Serial.println("Erro no retrieve");
  }
}
