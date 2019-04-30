#!/bin/bash


# -d代表存在 
prepend2() { [ -d "$2" ] && eval $1=\"$2':'\$$1\" && export $1; }


prepend(){ [ -d "$2" ] && eval $1=\"$2\$\{$1:+':'\$$1\}\" && export $1 ; }

                   
prepend3(){ 
  if [ -d "$2" ];then
    #eval PATH=
    eval $1=\"$2\$\{$1:+':'\$$1\}\"            
    #export $1; 
  fi
}


prepend3 $1 $2

echo $PATH


