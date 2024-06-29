package mongojava.github.com;

import mongojava.github.com.entity.Points;
import mongojava.github.com.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private PointsRepository pointsRepository;

    @ResponseBody
    @RequestMapping("/findByAccount/{account}")
    public Points findByAccount(@PathVariable String account) {
        return pointsRepository.findByAccount(account);
    }

    @ResponseBody
    @RequestMapping("/incByAccount/{account}/{inc}")
    public boolean findByAccount(@PathVariable String account, @PathVariable Integer inc) {
        return pointsRepository.incAmount(account, inc);
    }
}
