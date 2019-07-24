package br.com.vinhos.Factory;

import br.com.vinhos.DTO.HistoricoDTO;
import br.com.vinhos.Entity.Historico;

import static java.util.stream.Collectors.toList;

public abstract class HistoricoFactory {

    public static Historico getHistorico(HistoricoDTO historicoDTO){
        return Historico.builder()
                .codigo(historicoDTO.getCodigo())
                .data(ParseData.stringToLocalDate(historicoDTO.getData()))
                .itens(historicoDTO.getItens()
                        .stream()
                        .map(ItemFactory::getITem)
                        .collect(toList()))
                .valorTotal(historicoDTO.getValorTotal())
                .build();
    }

    public static HistoricoDTO getHistorico(Historico historico){
        return HistoricoDTO.builder()
                .codigo(historico.getCodigo())
                .data(ParseData.localDateToString(historico.getData()))
                .itens(historico.getItens()
                        .stream()
                        .map(ItemFactory::getITem)
                        .collect(toList()))
                .valorTotal(historico.getValorTotal())
                .build();
    }
}
