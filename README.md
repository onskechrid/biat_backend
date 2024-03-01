public boolean deleteMenuTree(Long idMenu){
        //houni bech nafskhou el menu houwa w sgharou
        if(menuRepository.getChildren(idMenu) != null){
            List<RC_Menu> children = menuRepository.getChildren(idMenu);
            for(RC_Menu child : children){
                deleteMenuTree(child.getId());
                this.delete(child.getId());
            }
            return true;
        }
        return false;
    }
