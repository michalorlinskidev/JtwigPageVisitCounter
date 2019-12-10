package tool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

@Service
@ApplicationScope
@Slf4j
public class PageVisitCounterService {
    private final AtomicReference<BigInteger> counter;

    public PageVisitCounterService() {
        this.counter = new AtomicReference(BigInteger.ZERO);
    }

    public BigInteger count() {
        return counter.accumulateAndGet(BigInteger.ONE, BigInteger::add);
    }
}
