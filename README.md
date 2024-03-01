public boolean deleteMenuSolo(Long idMenu){
        RC_Menu m = get(idMenu);
        RC_Menu parent = get(menuRepository.getParent(m.getIdparent()));
        //houni bech nafskhou el menu w bech nzidou level ta3 sgharou a sghar sgharou +1
        if(menuRepository.getChildren(idMenu) != null){
            List<RC_Menu> children = menuRepository.getChildren(idMenu);
            for(RC_Menu child : children){
                deleteMenuSolo(child.getId());
            }
        }
        m.setLevell(m.getLevell()+1);
        m.setIdparent(parent.getId());
        delete(idMenu);
    }
