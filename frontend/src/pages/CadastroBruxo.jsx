import React, { useState } from 'react';
import axios from 'axios';
import bgCastle from '../assets/bg-castle.png';

// CORREÇÃO 1: Adicionamos o 'onCadastroSucesso' aqui nos parâmetros recebidos
export default function CadastroBruxo({ casa, onVoltar, onCadastroSucesso }) {
  const [nome, setNome] = useState('');
  const [idade, setIdade] = useState('');
  const [nivelMagia, setNivelMagia] = useState('INICIANTE');
  const [carregando, setCarregando] = useState(false);

  // Mapeamento visual para customizar a página dependendo da casa escolhida
  const estilosCasas = {
    AQUARIS: { borda: 'border-cyan-500/40', texto: 'text-cyan-400', botao: 'from-cyan-600 to-blue-600', sombra: 'shadow-cyan-500/20' },
    IGNIS: { borda: 'border-orange-500/40', texto: 'text-orange-500', botao: 'from-orange-600 to-red-600', sombra: 'shadow-orange-500/20' },
    VENTUS: { borda: 'border-emerald-500/40', texto: 'text-emerald-400', botao: 'from-emerald-600 to-teal-600', sombra: 'shadow-emerald-500/20' },
    TERRAE: { borda: 'border-amber-700/40', texto: 'text-amber-600', botao: 'from-amber-700 to-amber-900', sombra: 'shadow-amber-700/20' },
  };

  const configVisual = estilosCasas[casa.id] || estilosCasas.AQUARIS;

  const handleSubmitReal = async (e) => {
    e.preventDefault();

    if (!nome.trim() || !idade){
      alert("⚠️ Preencha todos os pergaminhos!");
      return;
    } 

    setCarregando(true);

    const novoBruxo = {
      nome: nome,
      idade: Number(idade),
      anoEscolar: 1,
      nivelAprendizadoMagia: nivelMagia,
      casa: { id: casa.id }
    };

    try {
      // Chamada para o endpoint @PostMapping do BruxoController
      const response = await axios.post('http://localhost:8080/bruxos', novoBruxo);
      
      alert(`🔮 Bem-vindo(a), ${nome}! Matrícula realizada com sucesso.`);
      
      // Passa os dados salvos (incluindo o ID gerado pelo banco) para o App
      onCadastroSucesso(response.data); 
    } catch (error) {
      console.error("Erro ao registrar no Grimório:", error);
      alert("❌ O ritual falhou. Verifique se o backend está ativo.");
    } finally {
      setCarregando(false);
    }
  };
  

  return (
    <div 
      className="relative min-h-screen bg-cover bg-center bg-no-repeat flex items-center justify-center p-4 select-none"
      style={{ backgroundImage: `url(${bgCastle})` }}
    >
      <div className="absolute inset-0 bg-black/80 backdrop-blur-sm z-0"></div>

      <div className="relative z-10 w-full max-w-lg bg-slate-950/90 border border-amber-500/30 rounded-2xl p-8 md:p-10 shadow-2xl backdrop-blur-md my-auto" style={{ borderColor: casa.glow?.split(' ')[1]?.split('/')[0] || '#f59e0b' }}>
        
        {/* Título adaptável à Casa */}
        <div className="text-center mb-6">
          <button type="button" onClick={onVoltar} className="text-xs text-slate-400 hover:text-amber-400 uppercase tracking-widest absolute top-4 left-6 transition-colors">
            ← Voltar
          </button>
          <span className={`text-sm font-bold tracking-[0.3em] uppercase ${configVisual.texto}`}>
            Linhagem {casa.nome}
          </span>
          <h2 className="text-3xl md:text-4xl font-serif font-bold text-slate-100 mt-2">
            Matrícula Mística
          </h2>
          <div className="w-20 h-[1px] bg-slate-700 mx-auto mt-3"></div>
        </div>

        <form onSubmit={handleSubmit} className="space-y-5">
          <div>
            <label className="block text-xs text-slate-400 uppercase tracking-wider mb-1">Nome de Conjurador</label>
            <input 
              type="text" 
              required
              placeholder="Ex: Albus Custos"
              value={nome}
              onChange={(e) => setNome(e.target.value)}
              className="w-full bg-slate-900 border border-slate-700/60 rounded-lg px-3 py-2 text-sm text-white focus:outline-none focus:border-amber-500 transition-colors"
            />
          </div>

          <div>
            <label className="block text-xs text-slate-400 uppercase tracking-wider mb-1">Idade Terrena</label>
            <input 
              type="number" 
              required
              placeholder="Ex: 17"
              min="1"
              value={idade}
              onChange={(e) => setIdade(e.target.value)}
              className="w-full bg-slate-900 border border-slate-700/60 rounded-lg px-3 py-2 text-sm text-white focus:outline-none focus:border-amber-500 transition-colors"
            />
          </div>

          <div>
            <label className="block text-xs text-slate-400 uppercase tracking-wider mb-1">Grau de Afinidade Mágica</label>
            <select 
              value={nivelMagia}
              onChange={(e) => setNivelMagia(e.target.value)}
              className="w-full bg-slate-900 border border-slate-700/60 rounded-lg px-3 py-2 text-sm text-slate-300 focus:outline-none focus:border-amber-500 transition-colors"
            >
              <option value="INICIANTE">Iniciante (Neófito)</option>
              <option value="INTERMEDIARIO">Intermediário (Adepto)</option>
              <option value="AVANCADO">Avançado (Magus)</option>
            </select>
          </div>

          <button
            type="submit"
            disabled={carregando}
            className={`w-full mt-4 bg-gradient-to-r ${configVisual.botao} text-white font-bold uppercase text-xs tracking-widest py-3 rounded-lg shadow-lg hover:brightness-110 active:scale-[0.98] transition-all disabled:opacity-50`}
          >
            {carregando ? 'Gravando no Grimório...' : '⚡ Selar Matrícula'}
          </button>
        </form>
      </div>
    </div>
  );
}