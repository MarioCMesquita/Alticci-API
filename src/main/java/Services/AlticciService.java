package Services;

import io.quarkus.cache.CacheResult;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;

@ApplicationScoped
public class AlticciService {

    @CacheResult(cacheName = "alticci-cache")
    public Integer GetAlticci(int number)
    {
        try
        {
            // Creates HashMap with know values
            HashMap<Integer, Integer> knowValues = new HashMap<>();
            knowValues.put(0, 0);
            knowValues.put(1, 1);
            knowValues.put(2, 1);

            var tryGetPosition = knowValues.get(number);

            if (tryGetPosition == null) {
                var amountToGenerate = number - knowValues.size();
                var startPoint = knowValues.size();

                // Calculates and Add to "knowValues" until reach the "number"
                for (int i = 0; i <= amountToGenerate; i++) {
                    var firstVal = (startPoint - 3);
                    var secondVal = (startPoint - 2);
                    var newValue = knowValues.get(firstVal) + knowValues.get(secondVal);

                    knowValues.put(startPoint, newValue);

                    startPoint += 1;
                }
            }

            return knowValues.get(number);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
