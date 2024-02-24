package ru.kpfu.itis.service;


import ru.kpfu.itis.models.Viewer;
import ru.kpfu.itis.repository.Impl.ViewerRepositoryImpl;
import ru.kpfu.itis.repository.ViewerRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewerService {

    private ViewerRepository viewerRepository;

    public ViewerService(){
        viewerRepository = new ViewerRepositoryImpl();
    }

    public List<Viewer> getAllViewers(){
        return viewerRepository.findAll();
    }
    public void saveViewer(Viewer viewer) {
        viewerRepository.save(viewer);
    }

    public Viewer getViewer(String username, String pass){
        List<Viewer> viewers =  viewerRepository.findAll();
        Viewer res = null;
        for(Viewer viewer: viewers){
            if(viewer.getPassword().equals(pass) && viewer.getUsername().equals(username)){
                res = viewer;
                break;
            }
        }
        return res;
    }
    public Viewer getViewerByEmail(String username, String pass){
        List<Viewer> viewers=  viewerRepository.findAll();
        Viewer res = null;
        for(Viewer viewer: viewers){
            if(viewer.getPassword().equals(pass) && viewer.getEmail().equals(username)){
                res = viewer;
                break;
            }
        }
        return res;
    }

    public void auth (Viewer viewer, HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("user", viewer);
    }
    public boolean isNonGuest(HttpServletRequest req, HttpServletResponse resp){
        return req.getSession().getAttribute("user") != null;
    }

    public Viewer getUser(HttpServletRequest req, HttpServletResponse resp){
        return (Viewer) req.getSession().getAttribute("user");
    }

    public Viewer getViewerByLogin(String username){
        List<Viewer> viewers= getAllViewers();
        Viewer res = null;
        for(Viewer viewer: viewers){
            if(viewer.getUsername().equals(username)){
                res = viewer;
                break;
            }
        }
        return res;
    }

}
