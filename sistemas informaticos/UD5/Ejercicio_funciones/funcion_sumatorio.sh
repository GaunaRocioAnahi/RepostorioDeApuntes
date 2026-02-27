#!/bin/bash
sumatorio_rapido() {
    limite=$1
    # Usamos limite directamente en la fórmula, sin bucles, sin contadores
    # Una sola línea y tenemos el resultado
    resultado=$(( limite * (limite + 1) / 2 ))
    echo $resultado
}

sumatorio_rapido $1