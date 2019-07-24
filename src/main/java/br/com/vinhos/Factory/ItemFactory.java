package br.com.vinhos.Factory;

import br.com.vinhos.DTO.ItemDTO;
import br.com.vinhos.Entity.Item;

public abstract class ItemFactory {

    public static Item getITem(ItemDTO itemDTO){
        return Item.builder()
                .produto(itemDTO.getProduto())
                .variedade(itemDTO.getVariedade())
                .pais(itemDTO.getPais())
                .categoria(itemDTO.getCategoria())
                .safra(itemDTO.getSafra())
                .preco(itemDTO.getPreco())
                .build();
    }

    public static ItemDTO getITem(Item item){
        return ItemDTO.builder()
                .produto(item.getProduto())
                .variedade(item.getVariedade())
                .pais(item.getPais())
                .categoria(item.getCategoria())
                .safra(item.getSafra())
                .preco(item.getPreco())
                .build();
    }
}
