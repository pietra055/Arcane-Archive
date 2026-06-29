import React, { useState, useEffect } from 'react';
import axios from 'axios';

// Defina a URL base do seu servidor
const API_URL = 'http://localhost:8080';

export default function Ranking({ onVoltar }) {
  const [casas, setCasas] = useState([]);
  const [carregando, setCarregando] = useState(true);
  const [erro, setErro] = useState(null);

  useEffect(() => {
    const buscarRanking = async () => {
      try {
        setCarregando(true);
        // Ajuste para o endpoint que você criou no seu CasaController
        const response = await axios.get(`${API_URL}/casas`);
        
        // Ordena no frontend: maior pontuação primeiro
        const dadosOrdenados = response.data.sort((a, b) => b.pontuacao - a.pontuacao);
        setCasas(dadosOrdenados);
      } catch (err) {
        console.error("Erro ao conectar no backend:", err);
        setErro("Não foi possível carregar o ranking das casas.");
      } finally {
        setCarregando(false);
      }
    };

    buscarRanking();
  }, []);

  return (
    <div className="relative z-10 w-full max-w-2xl bg-slate-950/80 border border-amber-500/20 p-8 rounded-2xl backdrop-blur-md shadow-2xl mx-auto mt-10">
      <h2 className="text-3xl font-serif font-bold text-amber-500 text-center mb-8 tracking-widest">
        🏆 Ranking das Casas
      </h2>

      {carregando ? (
        <p className="text-center text-slate-400">Consultando o oráculo...</p>
      ) : erro ? (
        <p className="text-center text-red-400">{erro}</p>
      ) : (
        <div className="space-y-4">
          {casas.map((casa, index) => (
            <div 
              key={casa.id} 
              className="flex justify-between items-center bg-slate-900/60 p-4 rounded-xl border border-slate-800 hover:border-amber-500/30 transition-all"
            >
              <div className="flex items-center gap-4">
                <span className={`text-2xl font-bold w-8 ${index === 0 ? 'text-yellow-400' : 'text-slate-500'}`}>
                  {index + 1}º
                </span>
                <span className="font-serif text-xl text-slate-100">{casa.nome}</span>
              </div>
              <div className="text-right">
                <span className="block text-amber-400 font-bold text-lg">{casa.pontuacao}</span>
                <span className="text-[10px] text-slate-500 uppercase tracking-widest">Prestígio</span>
              </div>
            </div>
          ))}
        </div>
      )}

      <button 
        onClick={onVoltar}
        className="w-full mt-8 py-3 text-slate-400 hover:text-amber-400 uppercase tracking-widest text-xs transition-colors border-t border-slate-800"
      >
        ← Voltar ao Salão Comunal
      </button>
    </div>
  );
}