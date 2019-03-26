# pgm-ppm-reader
Projeto para disciplina de processamento digital de imagens.

### Funcionalidades
- Abre imagens nos formatos pgm e ppm;
- Permite editar as imagens utilizando os métodos a seguir:
 
### Negativo da imagem
- retorna a imagem negativa;

### Métodos de calculo de intensidade 
- retorna a imagem escurecida por subtração;
- retorna a imagem escurecida por divisão;
- retorna a imagem clareada por soma;
- retorna a imagem clareada por multiplicação;

### Rotação
- retorna a imagem rotacionada no angulo passado pelo parametro;

### Espelhar imagem
- retorna a imagem espelhada verticalmente;
- retorna a imagem espelhada horizontalmente;

### Zoom 
- Método que da zoom na imagem;

### Filtragem de ruídos
- Método que calcula a média padrão no pixel central utilizando uma mascara 3x3;
- Método que calcula amédia ponderada no pixel central utilizando uma mascara 3x3;
- Método de laplace com peso 4;
- Método de laplace com peso 8;
- Método que aplica o filtro da mediana;

### Métodos gama
- Método de Potência de gamma;
- Método de Potência de gamma que intensifica os valores no intervalo e preserva os outros valores;
- Método de Potência de gamma que intensifica os valores no intervalo e reduz ao minimo os outros valores;
- Método que reduz a intensidade da imagem;

### Cores
- Método que atribui pseudocores à uma foto em tons de cinza;
- Método que aumenta a tonalizade vermelha;
- Método que aumenta a tonalizade verde;
- Método que aumenta a tonalizade azul;

### Histograma
- Método que cria o histograma;
- Método de equalização global;

### Conversão do formato de cores
- Método que converte o modelo de cor da imagem de RGB para CMY;
- Método que converte o modelo de cor da imagem de RGB para HSI.
