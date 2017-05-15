package aspects;


import domain.Event;
import domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alisa on 5/15/2017.
 */
public aspect CachingAspect {
//    private Logger logger = Logger.getLogger("Caching");
//    private Map<Integer, User> cacheUser;
//    private Map<Integer, Event> cacheBlog;
//
//    public CachingAspect() {
//        cacheUser = new HashMap<>();
//        cacheBlog = new HashMap<>();
//    }
//
//    pointcut cachedOperationUser(Integer id):execution(public User repositories..*Repository+.findOne(*))&&args(id);
//    pointcut cachedOperationUsers():execution(public List<User> repositories..*Repository+.getAll(*));
//    pointcut cachedOperationEvent(Integer id):execution(public Event repositories..*Repository+.findOne(*))&&args(id);
//    pointcut cachedOperationEvents():execution(public List<Event> repositories..*Repository+.getAll(*));
//
//    User around(Integer id) : cachedOperationUser(id){
//        User user = cacheUser.get(id);
//        if (user == null) {
//            logger.info("Caching user with id = " + id);
//            user = proceed(id);
//            cacheUser.put(id, user);
//        }
//        return user;
//    }
//
//    Event around(Integer id) : cachedOperationEvent(id){
//        Event event = cacheBlog.get(id);
//        if (event == null) {
//            logger.info("Caching event with id = " + id);
//            event = proceed(id);
//            cacheBlog.put(id, event);
//        }
//        return event;
//    }
}
